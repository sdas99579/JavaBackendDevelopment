package org.gfg.minor1.service;

//import jakarta.transaction.Transactional;
import org.gfg.minor1.request.TxnReturnRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import org.gfg.minor1.exception.TxnException;
import org.gfg.minor1.model.*;
import org.gfg.minor1.repository.TxnRepository;
import org.gfg.minor1.request.TxnCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TxnService {

    @Autowired
    private TxnRepository txnRepository;


    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;


    @Value("${student.valid.days}")
    private String validUpto;


    @Value("${student.delayed.finePerDay}")
    private String finePerDay;


    private Student filterStudent(FilterStudent type, String value) throws TxnException {
        List<Student> studentList = studentService.filter(type, value);

        if(studentList==null || studentList.isEmpty())
        {
            throw new TxnException("Student doesnot belongs to my library");
        }

        Student studentFromDB = studentList.get(0);
        return studentFromDB;
    }


    private Book filterBook(FilterType type, Operator operator, String value) throws TxnException {
        List<Book> bookList = bookService.filter(type, operator,value);

        if(bookList==null || bookList.isEmpty())
        {
            throw new TxnException("Book is not from this library");
        }

        Book bookFromLib = bookList.get(0);
        return bookFromLib;
    }

    @Transactional(rollbackFor = {TxnException.class})//need to ude rollbackFor
    public String create(TxnCreateRequest txnCreateRequest) throws TxnException {

        Student studentFromDB = filterStudent(FilterStudent.PHONE_NO, txnCreateRequest.getStudentContact());


        Book bookFromLib = filterBook(FilterType.BOOK_NO, Operator.EQUALS,txnCreateRequest.getBookNo());

        if(bookFromLib.getStudent()!=null)
        {
            throw new TxnException("Book has already assigned to someone else");
        }

        String txnid = UUID.randomUUID().toString();
        Txn txn = Txn.builder()
                .student(studentFromDB)
                .paidAmount(txnCreateRequest.getAmount())
                .book(bookFromLib)
                .txnId(txnid)
                .txnStatus(TxnStatus.ISSUED)
                .build();

        txn = txnRepository.save(txn);

        bookFromLib.setStudent(studentFromDB);
        bookService.saveUpdate(bookFromLib);
        return txn.getTxnId();

//        return createTxnInDb(txn,bookFromLib,studentFromDB);
    }



//    @Transactional(rollbackFor = {TxnException.class})
//    public String createTxnInDb(Txn txn,Book bookFromLib,Student studentFromDB)
//    {
//        txn = txnRepository.save(txn);
//
//        bookFromLib.setStudent(studentFromDB);
//        bookService.saveUpdate(bookFromLib);
//        return txn.getTxnId();
//    }

    /*
    student - check
    book-> book.getStudent
    txn -> update to issued or returned
    mark book as available


     */
    private int calculateSettelmentAmount(Txn txn)
    {
        long issueTime = txn.getCreatedOn().getTime();
        long returnTime = System.currentTimeMillis();

        long timediff = returnTime-issueTime;

//        int daysPassed = (int) TimeUnit.MILLISECONDS.toDays(timediff);
        int daysPassed = (int) TimeUnit.DAYS.convert(timediff,TimeUnit.MICROSECONDS);

        if(daysPassed>Integer.valueOf(validUpto))
        {
            int fineAmount = (daysPassed-Integer.valueOf(validUpto))*Integer.valueOf(finePerDay);
            return txn.getPaidAmount()-fineAmount;
        }
        return txn.getPaidAmount();
    }



    @Transactional(rollbackFor = {TxnException.class})
    public int returnBook(TxnReturnRequest txnReturnRequest) throws TxnException {

        Student studentFromDB = filterStudent(FilterStudent.PHONE_NO, txnReturnRequest.getStudentContact());
        Book bookFromLib = filterBook(FilterType.BOOK_NO, Operator.EQUALS,txnReturnRequest.getBookNo());

        if(bookFromLib.getStudent()!=null && bookFromLib.getStudent().equals(studentFromDB))
        {
            Txn txnFromDb = txnRepository.findByTxnId(txnReturnRequest.getTxnId());
            if(txnFromDb==null)
            {
                throw new TxnException("No transaction found with this transaction id");
            }

            int amount = calculateSettelmentAmount(txnFromDb);

            if(amount== txnFromDb.getPaidAmount())
            {
                txnFromDb.setTxnStatus(TxnStatus.RETURNED);
            }else {
                txnFromDb.setTxnStatus(TxnStatus.FINED);
            }

            txnFromDb.setPaidAmount(amount);

            //update the book and student null

            bookFromLib.setStudent(null);
            bookService.saveUpdate(bookFromLib);

            return amount;
        }
        else
        {
            throw new TxnException("The book either not assigned, may be assign to someone else ");
        }
    }
}
