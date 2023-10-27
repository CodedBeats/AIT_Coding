using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model.DataSetUserTableAdapters;

namespace Model
{
    public class UserDAO
    {
        // connect to the db
        TabUserTableAdapter tabUserTableAdapter = new TabUserTableAdapter();

        public User ValidateUserName(string userNameInput)
        {
            // execute query and store data in object
            DataSetUser.TabUserDataTable tabUserDataTable = tabUserTableAdapter.ValidateUsername(userNameInput);

            // check if username isn't found
            int dataCount = tabUserDataTable.Count;
            if (dataCount == 0)
            {
                // username not found
                return null;
            }
            else
            {
                // iterate through data storing each row in a new user
                foreach (DataRow row in tabUserDataTable)
                {
                    // check if username in this row matches input username
                    string userName = row["UserName"].ToString();
                    if (userName == userNameInput)
                    {
                        // create user obj of valid username
                        int uid = Convert.ToInt32(row["UID"]);
                        string password = row["Password"].ToString();
                        int userLevel = Convert.ToInt32(row["UserLevel"]);

                        User user = new User();
                        user.UID = uid;
                        user.UserName = userName;
                        user.Password = password;
                        user.UserLevel = userLevel;

                        /* === Not going to use UID and UserLevel in part 1 of this assessment, but it will be useful later ===*/

                        return user;
                    }
                }
                // username not found
                return null;
            }
        }
    }
}
