using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Model.DataSetBorrowTableAdapters;

namespace Model
{
    public class BorrowDAO
    {
        public List<Borrow> FindBorrowByUserID(string inputUserID)
        {
            // connect to user db and execute query with username to get user id
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.FindUserIDByName(inputUserID);

            // connect to borrow db
            TabBorrowTableAdapter tabBorrowTableAdapter = new TabBorrowTableAdapter();
            // execute query and store data in object
            DataSetBorrow.TabBorrowDataTable tabBorrowDataTable = tabBorrowTableAdapter.GetUserBorrowed(userID);

            // check if there isn't data
            int dataCount = tabBorrowDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of borrows
                List<Borrow> borrows = new List<Borrow>();

                // iterate through data storing each row in a new borrow
                foreach (DataRow row in tabBorrowDataTable)
                {
                    // store user data in correct format in variables
                    int bid = Convert.ToInt32(row["BID"]);
                    int uid = Convert.ToInt32(row["UID"]);
                    string isbn = row["ISBN"].ToString();

                    string sqlDateString = row["BorrowDate"].ToString();
                    DateTime BorrowDate = DateTime.Parse(sqlDateString);

                    sqlDateString = row["ReturnDate"].ToString();
                    DateTime ReturnDate = DateTime.Parse(sqlDateString);

                    sqlDateString = row["ActualReturnDate"].ToString();
                    DateTime ActualReturnDate = DateTime.Parse(sqlDateString);

                    double LateFee = Convert.ToDouble(row["LateFee"]);

                    // set borrow data with created variables
                    Borrow borrow = new Borrow();
                    borrow.BID = bid;
                    borrow.UID = uid;
                    borrow.ISBN = isbn;
                    borrow.BorrowDate = BorrowDate;
                    borrow.ReturnDate = ReturnDate;
                    borrow.ActualReturnDate = ActualReturnDate;
                    borrow.LateFee = LateFee;

                    // add borrow to list
                    borrows.Add(borrow);
                }

                return borrows;
            }
        }


        // add borrow row
        public bool BorrowBook(string bookName, string username)
        {
            // connect to borrow db
            TabBorrowTableAdapter tabBorrowTableAdapter = new TabBorrowTableAdapter();

            // get book ISBN
            BookDAO bookDAO = new BookDAO();
            string bookISBN = bookDAO.FindBookIDByName(bookName);
            if (bookISBN == "n/a") return false;

            // get userID
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.FindUserIDByName(username);

            // get current date
            DateTime date = DateTime.Now.Date;
            // ASSUMPTION, default return date is 30 days from borrowing
            DateTime intendedReturnDate = date.AddDays(30).Date;

            // execute query (ASSUMPTION, since actual return date can't be null it will just be the inteded return date)
            tabBorrowTableAdapter.BorrowBook(userID, bookISBN, date.ToString(), intendedReturnDate.ToString(), intendedReturnDate.ToString(), 0);
            return true;
        }


        // update borrow row
        public bool ReturnBook(string bookName, string username)
        {
            // connect to borrow db
            TabBorrowTableAdapter tabBorrowTableAdapter = new TabBorrowTableAdapter();

            // get book ISBN
            BookDAO bookDAO = new BookDAO();
            string bookISBN = bookDAO.FindBookIDByName(bookName);
            if (bookISBN == "n/a") return false;

            // get userID
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.FindUserIDByName(username);

            // get current date
            DateTime date = DateTime.Now.Date;

            // handle late fee
            double lateFee = 1.5;

            // execute query
            tabBorrowTableAdapter.ReturnBook(date.ToString(), (decimal)lateFee, userID, bookISBN);
            return true;
        }
    }
}
