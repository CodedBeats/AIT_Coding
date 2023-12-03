using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using LanguageDTO = DTO.LanguageDTO;

namespace Controller
{
    public class LanguageController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();


        public List<LanguageDTO> GetAllLanguages()
        {
            // create list
            List<LanguageDTO> languageDTOs = new List<LanguageDTO>();

            Controller.ServiceReferenceLibrarySystem.Language[] languages = soapClient.GetAllLanguages();

            foreach (Language language in languages)
            {
                // create new languageDTO
                LanguageDTO languageDTO = new LanguageDTO();

                // assign values
                languageDTO.LID = language.LID;
                languageDTO.LanguageName = language.LanguageName;

                // add to list
                languageDTOs.Add(languageDTO);
            }

            return languageDTOs;
        }


        // CRUD
        public void CreateLanguage(string languageName)
        {
            soapClient.CreateLanguage(languageName);
        }

        public void UpdateLanguage(string languageName, int languageID)
        {
            soapClient.UpdateLanguage(languageName, languageID);
        }

        public void DeleteLanguage(int languageID)
        {
            soapClient.DeleteLanguage(languageID);
        }
    }
}
