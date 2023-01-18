/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#include "mainwindow.hh"
#include "ui_mainwindow.h"
#include <QFile>
#include <QTextStream>


MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    connect(ui->findPushButton, &QPushButton::clicked, this, &MainWindow::on_findPushButton_clicked);
}

MainWindow::~MainWindow()
{
    delete ui;
}




void MainWindow::on_fileLineEdit_editingFinished()
{
    inputFileName_ = ui->fileLineEdit->text();


}

void MainWindow::readFile(QString file)
{

    QFile inputFile(file);

    if(!inputFile.open(QIODevice::ReadOnly))
    {
        fileFound = false;
        return;
    }
    QTextStream inFile(&inputFile);

    while(!inFile.atEnd())
    {
        QString line = inFile.readLine();
        qDebug() << line;
        strings_ << line.split(" ");
    }

    inputFile.close();
    fileFound = true;

}


void MainWindow::on_findPushButton_clicked()
{
    strings_.clear();
    ui->textBrowser->clear();


    readFile(inputFileName_);
    searchForGivenWord();
    printResults();
}


void MainWindow::on_keyLineEdit_editingFinished()
{
    keyWord_ = ui->keyLineEdit->text();
}

void MainWindow::searchForGivenWord()
{
    if(!strings_.empty() && !keyWord_.isEmpty())
    {
        if(ui->matchCheckBox->isChecked())
        {
            for(QString& word : strings_)
            {
                if(word == keyWord_)
                {
                    givenWordFound = true;
                    return;
                }
            }

            givenWordFound = false;
        }
        else
        {
            QString keyWordUp = keyWord_.toUpper();
            for(QString& word : strings_)
            {
                QString wordUp = word.toUpper();
                if(wordUp == keyWordUp)
                {
                    givenWordFound = true;
                    return;
                }
            }

            givenWordFound = false;
        }

    }
}

void MainWindow::printResults()
{
    if(!fileFound)
    {
        ui->textBrowser->setText("File not found");
    }
    if(fileFound)
    {
       if(keyWord_.isEmpty()){
           ui->textBrowser->setText("File found");
           return;
       }
       if(!givenWordFound){
           ui->textBrowser->setText("Word not found");
           return;
       }
       if(givenWordFound) {
           ui->textBrowser->setText("Word found");
           return;
       }

    keyWord_.clear();
    }
}

