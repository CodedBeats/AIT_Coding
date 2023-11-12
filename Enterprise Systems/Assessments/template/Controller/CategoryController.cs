using DTO;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Controller
{
    public class CategoryController
    {
        public List<CategoryDTO> GetAllCategories()
        {
            CategoryLogic categoryLogic = new CategoryLogic();
            return categoryLogic.GetAllCategories();
        }

        public void CreateCategory(string categoryName)
        {
            CategoryLogic categoryLogic = new CategoryLogic();
            categoryLogic.CreateCategory(categoryName);
        }

        public void UpdateCategory(int categoryId, string categoryName)
        {
            CategoryLogic categoryLogic = new CategoryLogic();
            categoryLogic.UpdateCategory(categoryId, categoryName);
        }

        public void DeleteCategory(int categoryId)
        {
            CategoryLogic categoryLogic = new CategoryLogic();
            categoryLogic.DeleteCategory(categoryId);
        }
    }
}
