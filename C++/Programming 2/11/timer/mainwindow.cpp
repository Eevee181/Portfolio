/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#include "mainwindow.hh"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    //Connect elements of timer
    timer = new QTimer(this);
    connect(timer, &QTimer::timeout, this, &MainWindow::onTimerTimeout);
    // set timer
    timer->setInterval(1000);
    connect(ui->startButton, &QPushButton::clicked, this, &MainWindow::onStartButtonClicked);
    connect(ui->stopButton, &QPushButton::clicked, this, &MainWindow::onStopButtonClicked);
    connect(ui->resetButton, &QPushButton::clicked, this, &MainWindow::onResetButtonClicked);
    connect(ui->closeButton, &QPushButton::clicked, this, &MainWindow::onCloseButtonClicked);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::onStartButtonClicked()
{
    timer->start();
}

void MainWindow::onStopButtonClicked()
{
    if(timer)
    {
        timer->stop();
    }
}

void MainWindow::onResetButtonClicked()
{
    if(timer)
    {
        timer->stop();
        seconds_ = 0;
        updateView();
    }
}

void MainWindow::onCloseButtonClicked()
{
    if(timer){delete timer;}
    close();
}

void MainWindow::onTimerTimeout()
{
    seconds_++;
    updateView();
}

void MainWindow::updateView()
{
    int minutes = seconds_/60;
    int remainingSeconds = seconds_%60;

    ui->lcdNumberMin->display(minutes);
    ui->lcdNumberSec->display(remainingSeconds);
}
