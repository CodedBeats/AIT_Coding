using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using CategoryDTO = DTO.CategoryDTO;

namespace Controller
{
    public class CategoryController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();


        public List<CategoryDTO> GetAllCategories()
        {
            // create list
            List<CategoryDTO> categoryDTOs = new List<CategoryDTO>();

            Controller.ServiceReferenceLibrarySystem.Category[] categories = soapClient.GetAllCategories();

            foreach (Category category in categories)
            {
                // create new categoryDTO
                CategoryDTO categoryDTO = new CategoryDTO();

                // assign values
                categoryDTO.CID = category.CID;
                categoryDTO.CategoryName = category.CategoryName;

                // add to list
                categoryDTOs.Add(categoryDTO);
            }

            return categoryDTOs;
        }


        // CRUD
        public void CreateCategory(string categoryName)
        {
            soapClient.CreateCategory(categoryName);
        }

        public void UpdateCategory(int categoryID, string categoryName)
        {
            soapClient.UpdateCategory(categoryID, categoryName);
        }

        public void DeleteCategory(int categoryID)
        {
            soapClient.DeleteCategory(categoryID);
        }
    }
}
