using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model.DataSetUserTableAdapters;

namespace Model
{
    public class UserDAO
    {
        public void GetAllUsers()
        {
            // connects to the database
            TabUserTableAdapter tabUserTableAdapter = new TabUserTableAdapter();
            DataSetUser.TabUserDataTable tabUserDataTable = tabUserTableAdapter.GetAllUsers();
        }
    }
}
