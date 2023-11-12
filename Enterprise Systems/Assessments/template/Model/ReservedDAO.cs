using Model.DataSetBorrowTableAdapters;
using Model.DataSetReservedTableAdapters;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class ReservedDAO
    {
        public List<Reserved> FindReservedByUserID(string inputUserID)
        {
            // connect to user db and execute query with username to get user id
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.FindUserIDByName(inputUserID);

            // connect to reserved db
            TabReservedTableAdapter tabReservedTableAdapter = new TabReservedTableAdapter();
            // execute query and store data in object
            DataSetReserved.TabReservedDataTable tabReservedDataTable = tabReservedTableAdapter.GetUserReserved(userID);

            // check if there isn't data
            int dataCount = tabReservedDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of reserved
                List<Reserved> reserves = new List<Reserved>();

                // iterate through data storing each row in a new reserved
                foreach (DataRow row in tabReservedDataTable)
                {
                    // store user data in correct format in variables
                    int rid = Convert.ToInt32(row["RID"]);
                    int uid = Convert.ToInt32(row["UID"]);
                    string isbn = row["ISBN"].ToString();

                    string sqlDateString = row["ReservedDate"].ToString();
                    DateTime ReservedDate = DateTime.Parse(sqlDateString);

                    // set reserved data with created variables
                    Reserved reserved = new Reserved();
                    reserved.RID = rid;
                    reserved.UID = uid;
                    reserved.ISBN = isbn;
                    reserved.ReservedDate = ReservedDate;

                    // add borrow to list
                    reserves.Add(reserved);
                }

                return reserves;
            }
        }

        // add reserve row
        public bool ReserveBook(string bookName, string username)
        {
            // connect to reserved db
            TabReservedTableAdapter tabReservedTableAdapter = new TabReservedTableAdapter();

            // get book ISBN
            BookDAO bookDAO = new BookDAO();
            string bookISBN = bookDAO.FindBookIDByName(bookName);
            if (bookISBN == "n/a") return false;

            // get userID
            UserDAO userDAO = new UserDAO();
            int userID = userDAO.FindUserIDByName(username);

            // get current date
            DateTime date = DateTime.Now.Date;

            // execute query (ASSUMPTION, since actual return date can't be null it will just be the inteded return date)
            tabReservedTableAdapter.ReserveBook(userID, bookISBN, date.ToString());
            return true;
        }
    }
}
