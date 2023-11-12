using Model.DataSetCategoryTableAdapters;
using Model.DataSetLanguageTableAdapters;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class LanguageDAO
    {
        public List<Language> GetAllLanguages()
        {
            // connect to db
            TabLanguageTableAdapter tabLanguageTableAdapter = new TabLanguageTableAdapter();
            // execute query and store
            DataSetLanguage.TabLanguageDataTable tabLanguageDataTable = tabLanguageTableAdapter.GetAllLanguages();

            // check if there isn't data
            int dataCount = tabLanguageDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<Language> languages = new List<Language>();

                // iterate through data storing each row in a new language
                foreach (DataRow row in tabLanguageDataTable)
                {
                    // store language data in correct format in variables
                    int lid = Convert.ToInt32(row["LID"]);
                    string languageName = row["LanguageName"].ToString();

                    // set language data with created variables
                    Language language = new Language();
                    language.LID = lid;
                    language.LanguageName = languageName;

                    // add language to list
                    languages.Add(language);
                }

                return languages;
            }
        }


        public void CreateLanguage(string languageName)
        {
            // connect to db
            TabLanguageTableAdapter tabLanguageTableAdapter = new TabLanguageTableAdapter();
            // execute query
            tabLanguageTableAdapter.CreateLanguage(languageName);
        }


        public void UpdateLanguage(string languageName, int languageID)
        {
            // connect to db
            TabLanguageTableAdapter tabLanguageTableAdapter = new TabLanguageTableAdapter();
            // execute query
            tabLanguageTableAdapter.UpdateLanguage(languageName, languageID);
        }


        public void DeleteLanguage(int languageID)
        {
            // connect to db
            TabLanguageTableAdapter tabLanguageTableAdapter = new TabLanguageTableAdapter();
            // execute query
            tabLanguageTableAdapter.DeleteLanguage(languageID);
        }
    }
}
