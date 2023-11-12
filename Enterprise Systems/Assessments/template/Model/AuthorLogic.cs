using DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class AuthorLogic
    {
        public List<AuthorDTO> GetAllAuthors()
        {
            AuthorDAO authorDAO = new AuthorDAO();
            // create list of authors
            List<Author> authors = authorDAO.GetAllAuthors();

            // check if no authors
            if (authors == null)
            {
                return null;
            }

            // clone authors' data into AuthorDTO type authors
            List<AuthorDTO> authorDTOs = authors.Select(author => new AuthorDTO
            {
                AID = author.AID,
                AuthorName = author.AuthorName
            }).ToList();

            return authorDTOs;
        }


        public void CreateAuthor(string authorName)
        {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.CreateAuthor(authorName);
        }


        public void UpdateAuthor(string authorName, int authorID)
        {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.UpdateAuthor(authorName, authorID);
        }


        public void DeleteAuthor(int authorID)
        {
            AuthorDAO authorDAO = new AuthorDAO();
            authorDAO.DeleteAuthor(authorID);
        }
    }
}
