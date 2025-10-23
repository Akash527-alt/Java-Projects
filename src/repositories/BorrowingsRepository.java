package repositories;

import java.util.List;

import models.Borrowings;

public interface BorrowingsRepository {

    Borrowings addNewRecord(Borrowings borrow);
    Borrowings findActiveBorrowedByBoodId(Long bookId);
    List<Borrowings> findRecordByUserId(Long userId);
    List<Borrowings> findAll();



}
