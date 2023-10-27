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

/*
 * === ASSUMPTIONS ===
 * 1. Search criteria can be displayed as toggled buttons to switch between different criteria.
 * 2. For searching criteria that have string input for other tables but interger for book table, 
 *      they will be searched correctly in code,
 *      but still displayed with their number when displaying all matched books.
 * 3. All book data can just be displayed with the data grid and doesn't need any special formatiing or styling.
*/

namespace View
{
    public partial class FormDisplayDashboard : Form
    {
        // easy way to set search category state for switching and passing
        private int searchCat = 1;

        // connect to the Controller
        BookController bookController = new BookController();

        public FormDisplayDashboard()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void GetAllBooksBtn(object sender, EventArgs e)
        {
            List<BookDTO> bookDTOs = bookController.GetAllBooks();

            // display the data
            dataGridView1.DataSource = bookDTOs;
        }

        private void BookNameBtn(object sender, EventArgs e)
        {
            // set state
            searchCat = 1;

            // update btn style
            button6.BackColor = Color.FromArgb(192, 255, 192);
            button5.BackColor = Color.FromArgb(255, 255, 255);
            button3.BackColor = Color.FromArgb(255, 255, 255);
        }
        private void AuthorBtn(object sender, EventArgs e)
        {
            // set state
            searchCat = 2;

            // update btn style
            button6.BackColor = Color.FromArgb(255, 255, 255);
            button5.BackColor = Color.FromArgb(192, 255, 192);
            button3.BackColor = Color.FromArgb(255, 255, 255);
        }
        private void CategoryBtn(object sender, EventArgs e)
        {
            // set state
            searchCat = 3;

            // update btn style
            button6.BackColor = Color.FromArgb(255, 255, 255);
            button5.BackColor = Color.FromArgb(255, 255, 255);
            button3.BackColor = Color.FromArgb(192, 255, 192);
        }

        private void SearchBtn(object sender, EventArgs e)
        {
            List<BookDTO> bookDTOs = bookController.Search(textBox1.Text, searchCat);

            // display the data
            dataGridView1.DataSource = bookDTOs;
        }

        private void ExitBtn(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you want to close this form?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // close program
                Application.Exit();
            }
        }
    }
}
