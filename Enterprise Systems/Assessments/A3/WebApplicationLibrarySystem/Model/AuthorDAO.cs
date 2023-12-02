using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Model.DataSetAuthorTableAdapters;

namespace Model
{
    public class AuthorDAO
    {
        public int FindAuthorByName(string searchInput)
        {
            // connect to db
            TabAuthorTableAdapter tabAuthorTableAdapter = new TabAuthorTableAdapter();
            // execute query and store data in object
            DataSetAuthor.TabAuthorDataTable tabAuthorDataTable = tabAuthorTableAdapter.FindAuthorByName(searchInput);

            // init author ID
            int authorID = 0;

            // check if there isn't data
            int dataCount = tabAuthorDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return 0;
            }
            else
            {
                // iterate through data storing each row in a new user
                foreach (DataRow row in tabAuthorDataTable)
                {
                    // store user data in correct format in variables
                    authorID = Convert.ToInt32(row["AID"]);
                }

                return authorID;
            }
        }
    }
}
