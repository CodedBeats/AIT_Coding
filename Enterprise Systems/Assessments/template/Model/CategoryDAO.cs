using Model.DataSetCategoryTableAdapters;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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


        public List<Category> GetAllCategories()
        {
            // connect to db
            TabCategoryTableAdapter tabCategoryTableAdapter = new TabCategoryTableAdapter();
            // execute query and store
            DataSetCategory.TabCategoryDataTable tabCategoryDataTable = tabCategoryTableAdapter.GetAllCategories();

            // check if there isn't data
            int dataCount = tabCategoryDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<Category> categories = new List<Category>();

                // iterate through data storing each row in a new category
                foreach (DataRow row in tabCategoryDataTable)
                {
                    // store category data in correct format in variables
                    int cid = Convert.ToInt32(row["CID"]);
                    string categoryName = row["CategoryName"].ToString();

                    // set categort data with created variables
                    Category category = new Category();
                    category.CID = cid;
                    category.CategoryName = categoryName;

                    // add category to list
                    categories.Add(category);
                }

                return categories;
            }
        }


        public void CreateCategory(string categoryName)
        {
            // connect to db
            TabCategoryTableAdapter tabCategoryTableAdapter = new TabCategoryTableAdapter();
            // execute query
            tabCategoryTableAdapter.CreateCategory(categoryName);
        }


        public void UpdateCategory(int categoryID, string categoryName)
        {
            // connect to db
            TabCategoryTableAdapter tabCategoryTableAdapter = new TabCategoryTableAdapter();
            // execute query
            tabCategoryTableAdapter.UpdateCategory(categoryName, categoryID);
        }


        public void DeleteCategory(int categoryID)
        {
            // connect to db
            TabCategoryTableAdapter tabCategoryTableAdapter = new TabCategoryTableAdapter();
            // execute query
            tabCategoryTableAdapter.DeleteCategory(categoryID);
        }
    }
}
