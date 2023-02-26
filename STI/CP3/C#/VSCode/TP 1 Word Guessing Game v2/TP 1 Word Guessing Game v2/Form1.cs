using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Media;
using System.Reflection;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;

namespace TP_1_Word_Guessing_Game_v2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            string Input = textBox1.Text;
            {

                if (Input == "amongus")
                {

                    label1.Text = ("a m o n g u s");
                    label4.Visible = true;
                    button1.Visible = false;
                    textBox1.Visible = false;
                    pictureBox11.Visible = true;

                    if (listBox1.Items.Count >= 0)
                    {
                        pictureBox7.Visible = true;
                    }

                    if (listBox1.Items.Count >= 1)
                    {
                        pictureBox1.Visible = true;
                        pictureBox8.Visible = true;
                    }

                    if (listBox1.Items.Count >= 2)
                    {
                        pictureBox1.Visible = true;
                        pictureBox3.Visible = true;
                        pictureBox9.Visible = true;
                    }
                }
                else
                {
                    listBox1.Items.Add(Input);
                    if (listBox1.Items.Count > 0)
                    {
                        pictureBox1.Visible = true;
                    }

                    if (listBox1.Items.Count > 1)
                    {
                        pictureBox3.Visible = true;
                    }

                    if (listBox1.Items.Count > 2)
                    {
                        pictureBox5.Visible = true;
                        label4.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
                        label4.Text = ("           You Lost");
                        label4.Visible = true;
                        button1.Text = ("Exit");
                        textBox1.Visible = false;
                    }

                    if (listBox1.Items.Count > 3)
                    {
                        Environment.Exit(0);
                    }

                }
            }


        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void pictureBox7_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            pictureBox10.Visible = true;
        }
    }
}