using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using Model;

namespace WebApplicationLibrarySystem
{
    /// <summary>
    /// Summary description for WebServiceLibrarySystem
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebServiceLibrarySystem : System.Web.Services.WebService
    {
        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        // User
        [WebMethod]
        public string GetUser(int uid)
        {
            UserLogic userLogic = new UserLogic();

            return userLogic.GetUser(uid);
        }

        // test
        [WebMethod]
        public string TestFunc(int no1)
        {
            return "it's " + no1;
        }
    }
}
