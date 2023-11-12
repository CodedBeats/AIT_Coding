using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class CategoryLogic
    {
        public List<CategoryDTO> GetAllCategories()
        {
            CategoryDAO categoryDAO = new CategoryDAO();
            // create list of categories
            List<Category> categories = categoryDAO.GetAllCategories();

            // check if no categories
            if (categories == null)
            {
                return null;
            }

            // clone categories' data into CategoryDTO type categories
            List<CategoryDTO> categoryDTOs = categories.Select(category => new CategoryDTO
            {
                CID = category.CID,
                CategoryName = category.CategoryName
            }).ToList();

            return categoryDTOs;
        }


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
