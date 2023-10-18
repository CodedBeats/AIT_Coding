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
        public List<User> GetAllUsers()
        {
            //connects to the Database
            //and executing the Query and it return the data into the object tabUserDataTable
            TabUserTableAdapter tabUserTableAdapter = new TabUserTableAdapter();
            DataSetUser.TabUserDataTable tabUserDataTable = tabUserTableAdapter.GetAllUsers();

            //now traverse the tabUserDataTable and get all the data one by one (loop)
            //1st check if any data is returned
            int dataCount = tabUserDataTable.Count;
            if (dataCount == 0)
            {
                //this means there is not data in the table
                return null;
            }
            else
            {
                //create a List of User objects
                List<User> users = new List<User>();

                //there are data, so now traverse the tabUserDataTable and get all the data one by one (loop)
                foreach (DataRow row in tabUserDataTable)
                {
                    int uid = Convert.ToInt32(row["UID"]);
                    string userName = row["UserName"].ToString();
                    string password = row["Password"].ToString();
                    int userLevel = Convert.ToInt32(row["UserLevel"]);

                    //encapsulat the above data into a User Object (for this 1st we have to create an Entity class called User)
                    User user = new User();
                    user.Uid = uid;
                    user.UserName = userName;
                    user.Password = password;
                    user.UserLevel = userLevel;

                    //and then add that User Object into a List
                    users.Add(user);
                }

                //return the List of User Objects
                return users;
            }
        }
    }
}
