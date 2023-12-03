using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using AuthorDTO = DTO.AuthorDTO;

namespace Controller
{
    public class AuthorController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();


        public List<AuthorDTO> GetAllAuthors()
        {
            // create list
            List<AuthorDTO> authorDTOs = new List<AuthorDTO>();

            Controller.ServiceReferenceLibrarySystem.Author[] authors = soapClient.GetAllAuthors();

            foreach (Author author in authors)
            {
                // create new bookDTO
                AuthorDTO authorDTO = new AuthorDTO();

                // assign values
                authorDTO.AID = author.AID;
                authorDTO.AuthorName = author.AuthorName;

                // add to list
                authorDTOs.Add(authorDTO);
            }

            return authorDTOs;
        }


        // CRUD
        public void CreateAuthor(string authorName)
        {
            soapClient.CreateAuthor(authorName);
        }

        public void UpdateAuthor(string authorName, int authorID)
        {
            soapClient.UpdateAuthor(authorName, authorID);
        }

        public void DeleteAuthor(int authorID)
        {
            soapClient.DeleteAuthor(authorID);
        }
    }
}
