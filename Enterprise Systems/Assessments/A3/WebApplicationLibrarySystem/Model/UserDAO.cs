using System;
using System.Collections.Generic;
using System.Linq;
using System.Data;
using System.Text;
using System.Threading.Tasks;
using Model.DataSet1TableAdapters;

namespace Model
{
    public class UserDAO
    {
        // connect to the db
        TabUserTableAdapter tabUserTableAdapter = new TabUserTableAdapter();

        public string GetUser(int uid)
        {
            // execute query
            DataSet1.TabUserDataTable tabUserDataTable = tabUserTableAdapter.GetUser(uid);

            string username = "";

            // check if there isn't data
            int dataCount = tabUserDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return username;
            }
            else
            {
                // iterate through data storing each row in a new user (should only be 1)
                foreach (DataRow row in tabUserDataTable)
                {
                    // store user data in correct format in variable
                    username = row["Username"].ToString();
                }

                return username;
            }
        }
    }
}
