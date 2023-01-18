/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#ifndef MAINWINDOW_HH
#define MAINWINDOW_HH

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

private slots:
    void on_fileLineEdit_editingFinished();
    void readFile(QString file);

    void on_findPushButton_clicked();

    void on_keyLineEdit_editingFinished();
    void searchForGivenWord();
    void printResults();

private:
    Ui::MainWindow *ui;

    bool fileFound = false;
    bool givenWordFound = false;
    QString keyWord_;
    QString inputFileName_;
    QStringList strings_;
};
#endif // MAINWINDOW_HH
