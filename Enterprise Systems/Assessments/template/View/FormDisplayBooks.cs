using Controller;
using DTO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace View
{
    public partial class FormDisplayBooks : Form
    {
        public FormDisplayBooks()
        {
            InitializeComponent();
        }

        private void FormDisplayBooks_Load(object sender, EventArgs e)
        {

        }

        private void GetAllBooksBtn(object sender, EventArgs e)
        {
            // connect to the Controller
            BookController bookController = new BookController();
            List<BookDTO> bookDTOs = bookController.GetAllBooks();

            // display the data
            dataGridView1.DataSource = bookDTOs;
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }
    }
}
