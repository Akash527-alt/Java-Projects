package repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Borrowings;

public class BorrowingsRepositoryImpl implements BorrowingsRepository{

    private List<Borrowings> borrowings = new ArrayList<>();
    private Long borrowingId = 1L;


    @Override
    public Borrowings addNewRecord(Borrowings borrow) {
        if(borrow.getId() == null) {
            borrow.setId(borrowingId);
            borrowingId++;
        }
        borrowings.add(borrow);
        return borrow;
    }

    @Override
    public Borrowings findActiveBorrowedByBoodId(Long bookId) {
        for(Borrowings borrow : borrowings) {
            if(borrow.getBook().getId().equals(bookId) && borrow.getReturnDate() == null) {
                return borrow;
            }
        }
        return null;
    }

    @Override
    public List<Borrowings> findRecordByUserId(Long userId) {
        List<Borrowings> userRecords = new ArrayList<>();
        for(Borrowings borrow : borrowings) {
            if(borrow.getUser().getId().equals(userId)) {
                userRecords.add(borrow);
            }
        }
        return userRecords;
    }

    @Override
    public List<Borrowings> findAll() {

        return new ArrayList<>(borrowings);
    }

}
