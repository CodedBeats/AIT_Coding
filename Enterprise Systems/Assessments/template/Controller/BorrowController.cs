using DTO;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class BorrowController
    {
        public List<BorrowDTO> FindBorrowByUserID(string inputUserID)
        {
            BorrowLogic borrowLogic = new BorrowLogic();
            return borrowLogic.FindBorrowByUserID(inputUserID);
        }

        public bool BorrowBook(string bookName, string username)
        {
            BorrowLogic borrowLogic = new BorrowLogic();
            bool successfullBorrow = borrowLogic.BorrowBook(bookName, username);
            return successfullBorrow;
        }

        public bool ReturnBook(string bookName, string username)
        {
            BorrowLogic borrowLogic = new BorrowLogic();
            bool successfullReturn = borrowLogic.ReturnBook(bookName, username);
            return successfullReturn;
        }
    }
}
