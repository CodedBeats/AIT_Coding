using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class BorrowLogic
    {
        public List<BorrowDTO> FindBorrowByUserID(string inputUserID)
        {
            BorrowDAO borrowDAO = new BorrowDAO();
            // create list of borrows
            List<Borrow> borrows = borrowDAO.FindBorrowByUserID(inputUserID);

            // check if no borrows
            if (borrows == null)
            {
                return null;
            }

            // clone borrows' data into BorrowDTO type borrows
            List<BorrowDTO> borrowDTOs = borrows.Select(borrow => new BorrowDTO
            {
                BID = borrow.BID,
                UID = borrow.UID,
                ISBN = borrow.ISBN,
                BorrowDate = borrow.BorrowDate,
                ReturnDate = borrow.ReturnDate,
                ActualReturnDate = borrow.ActualReturnDate,
                LateFee = borrow.LateFee
            }).ToList();

            return borrowDTOs;
        }

        
        // borrow book
        public bool BorrowBook(string bookName, string username)
        {
            BorrowDAO borrowDAO = new BorrowDAO();
            bool successfullBorrow = borrowDAO.BorrowBook(bookName, username);
            return successfullBorrow;
        }


        // return book
        public bool ReturnBook(string bookName, string username)
        {
            BorrowDAO borrowDAO = new BorrowDAO();
            bool successfullReturn = borrowDAO.ReturnBook(bookName, username);
            return successfullReturn;
        }
    }
}
