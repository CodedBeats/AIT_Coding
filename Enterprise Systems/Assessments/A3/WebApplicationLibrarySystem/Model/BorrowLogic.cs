using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class BorrowLogic
    {
        public List<Borrow> FindBorrowByUserID(string inputUserID)
        {
            BorrowDAO borrowDAO = new BorrowDAO();
            // create list of borrows
            List<Borrow> borrows = borrowDAO.FindBorrowByUserID(inputUserID);

            return borrows;
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
