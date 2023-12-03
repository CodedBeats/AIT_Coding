using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using Model.DataSetAuthorTableAdapters;

namespace Model
{
    public class AuthorDAO
    {
        public int FindAuthorByName(string searchInput)
        {
            // connect to db
            TabAuthorTableAdapter tabAuthorTableAdapter = new TabAuthorTableAdapter();
            // execute query and store data in object
            DataSetAuthor.TabAuthorDataTable tabAuthorDataTable = tabAuthorTableAdapter.FindAuthorByName(searchInput);

            // init author ID
            int authorID = 0;

            // check if there isn't data
            int dataCount = tabAuthorDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return 0;
            }
            else
            {
                // iterate through data storing each row in a new user
                foreach (DataRow row in tabAuthorDataTable)
                {
                    // store user data in correct format in variables
                    authorID = Convert.ToInt32(row["AID"]);
                }

                return authorID;
            }
        }


        public List<Author> GetAllAuthors()
        {
            // connect to db
            TabAuthorTableAdapter tabAuthorTableAdapter = new TabAuthorTableAdapter();
            // execute query
            DataSetAuthor.TabAuthorDataTable tabAuthorDataTable = tabAuthorTableAdapter.GetAllAuthors();

            // check if there isn't data
            int dataCount = tabAuthorDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of authors
                List<Author> authors = new List<Author>();

                // iterate through data storing each row in a new author
                foreach (DataRow row in tabAuthorDataTable)
                {
                    // store author data in correct format in variables
                    int aid = Convert.ToInt32(row["AID"]);
                    string authorName = row["AuthorName"].ToString();

                    // set author data with created variables
                    Author author = new Author();
                    author.AID = aid;
                    author.AuthorName = authorName;

                    // add author to list
                    authors.Add(author);
                }

                return authors;
            }
        }


        // CRUD
        public void CreateAuthor(string authorName)
        {
            // connect to db
            TabAuthorTableAdapter tabAuthorTableAdapter = new TabAuthorTableAdapter();
            // execute query
            tabAuthorTableAdapter.CreateAuthor(authorName);
        }

        public void UpdateAuthor(string authorName, int authorID)
        {
            // connect to db
            TabAuthorTableAdapter tabAuthorTableAdapter = new TabAuthorTableAdapter();
            // execute query
            tabAuthorTableAdapter.UpdateAuthor(authorName, authorID);
        }


        public void DeleteAuthor(int authorID)
        {
            // connect to db
            TabAuthorTableAdapter tabAuthorTableAdapter = new TabAuthorTableAdapter();
            // execute query
            tabAuthorTableAdapter.DeleteAuthor(authorID);
        }
    }
}
