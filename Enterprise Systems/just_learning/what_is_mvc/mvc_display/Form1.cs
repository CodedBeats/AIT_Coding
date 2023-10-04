using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using what_is_mvc;

namespace mvc_display
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // === idk what these do but deleting them breaks shit lol === //
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {

        }
        // === === //



        // create calculator 
        Calculator c1 = new Calculator();

        // exit btn
        private void exitBtn_click(object sender, EventArgs e)
        {
            // confirmation message window
            DialogResult dr = MessageBox.Show("Are you sure you want to close this form?", "Confirmation of Form Closure", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                // close program
                Application.Exit();
            }
        }

        // clear btn
        private void clearBtn_click(object sender, EventArgs e)
        {
            textBox1.Clear();
            textBox2.Clear();
            textBox3.Clear();
        }

        private void addBtn_click(object sender, EventArgs e)
        {
            // set calculator values to user input
            c1.Num1 = Convert.ToDouble(textBox1.Text);
            c1.Num2 = Convert.ToDouble(textBox2.Text);

            // perform operation and display ans in text box
            textBox3.Text = $"{c1.Add()}";
        }

        private void subtractBtn_click(object sender, EventArgs e)
        {
            // set calculator values to user input
            c1.Num1 = Convert.ToDouble(textBox1.Text);
            c1.Num2 = Convert.ToDouble(textBox2.Text);

            // perform operation and display ans in text box
            textBox3.Text = $"{c1.Sub()}";
        }

        private void multiplyBtn_click(object sender, EventArgs e)
        {
            // set calculator values to user input
            c1.Num1 = Convert.ToDouble(textBox1.Text);
            c1.Num2 = Convert.ToDouble(textBox2.Text);

            // perform operation and display ans in text box
            textBox3.Text = $"{c1.Mul()}";
        }

        private void divideBtn_click(object sender, EventArgs e)
        {
            // set calculator values to user input
            c1.Num1 = Convert.ToDouble(textBox1.Text);
            c1.Num2 = Convert.ToDouble(textBox2.Text);

            // perform operation and display ans in text box
            textBox3.Text = $"{c1.Div()}";
        }
    }
}
