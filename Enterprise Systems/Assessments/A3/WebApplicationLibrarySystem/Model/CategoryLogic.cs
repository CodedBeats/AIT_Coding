using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class CategoryLogic
    {
        public List<Category> GetAllCategories()
        {
            CategoryDAO categoryDAO = new CategoryDAO();
            // create list of categories
            List<Category> categories = categoryDAO.GetAllCategories();

            return categories;
        }


        // CRUD
        public void CreateCategory(string categoryName)
        {
            CategoryDAO categoryDAO = new CategoryDAO();
            categoryDAO.CreateCategory(categoryName);
        }


        public void UpdateCategory(int categoryID, string categoryName)
        {
            CategoryDAO categoryDAO = new CategoryDAO();
            categoryDAO.UpdateCategory(categoryID, categoryName);
        }


        public void DeleteCategory(int categoryID)
        {
            CategoryDAO categoryDAO = new CategoryDAO();
            categoryDAO.DeleteCategory(categoryID);
        }
    }
}
