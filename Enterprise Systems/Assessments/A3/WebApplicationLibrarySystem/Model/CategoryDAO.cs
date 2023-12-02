using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Model.DataSetCategoryTableAdapters;

namespace Model
{
    public class CategoryDAO
    {
        public int FindCategoryByName(string searchInput)
        {
            // connect to db
            TabCategoryTableAdapter tabCategoryTableAdapter = new TabCategoryTableAdapter();
            // execute query and store data in object
            DataSetCategory.TabCategoryDataTable tabCategoryDataTable = tabCategoryTableAdapter.FindCategoryByName(searchInput);

            // init author ID
            int categoryID = 0;

            // check if there isn't data
            int dataCount = tabCategoryDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return 0;
            }
            else
            {
                // iterate through data storing each row in a new user
                foreach (DataRow row in tabCategoryDataTable)
                {
                    // store user data in correct format in variables
                    categoryID = Convert.ToInt32(row["CID"]);
                }

                return categoryID;
            }
        }
    }
}
