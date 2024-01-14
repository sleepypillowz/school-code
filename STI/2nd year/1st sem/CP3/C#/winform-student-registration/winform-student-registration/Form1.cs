using Microsoft.VisualBasic.FileIO;
using System.Drawing.Drawing2D;
using System.IO;
using System.Security.Cryptography.X509Certificates;
using System.Security.Permissions;
using static System.Net.WebRequestMethods;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace CP3_Lab_Excercise_1_Student_Registration_Form
{
   
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //opens file explorer
            OpenFileDialog open = new OpenFileDialog();
            //image filters  
            open.Filter = "Image Files(*.jpg; *.jpeg; *.gif; *.bmp)|*.jpg; *.jpeg; *.gif; *.bmp";
            
            if (open.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.Image = new Bitmap(open.FileName); //display image in picture box  
            }
        }
        private void button2_Click(object sender, EventArgs e)
        {
            //Decleration of Variables
            string gdr = "Male";
            bool perm = false;
            var labels = new List<Label> { label1, label2, label3, label4, label5, label6 }; //var takes care of the given data types such as int, string

            if (String.IsNullOrEmpty(textBox1.Text) || String.IsNullOrEmpty(textBox2.Text) || String.IsNullOrEmpty(textBox3.Text) ||
               (String.IsNullOrEmpty(comboBox1.Text) || String.IsNullOrEmpty(comboBox2.Text) || String.IsNullOrEmpty(comboBox3.Text) ||
               (String.IsNullOrEmpty(comboBox4.Text) || radioButton1.Checked == false && radioButton2.Checked == false)))
            {

                foreach (var label in labels)
                {
                    label.ForeColor = Color.Red;
                }
                perm = true;
            }
            else
            {
                foreach (var label in labels)
                {
                    label.ForeColor = Color.Black;
                }
                perm = true;
            }

            //Gender
            if (radioButton2.Checked == true)
            {
                gdr = "Female";
            }

            //checks if user has access
            if (perm == false)
            {
                MessageBox.Show("Missing Inputs", "!");
            }
            else if (perm == true)
            {
                //Displays in a MessageBox the input of the user
                MessageBox.Show($"Student Name: {textBox1.Text}, {textBox2.Text} {textBox3.Text} \n" + $"Gender: {gdr}\n" +
                $"Date of birth: {comboBox3.Text} / {comboBox1.Text} / {comboBox4.Text}\n" + $"Program: {comboBox2.Text}","Student Info");
            }
            else
            {
                Console.WriteLine("Error");
            }
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
    }
}