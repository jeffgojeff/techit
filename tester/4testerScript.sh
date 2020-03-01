#!/bin/bash


echo -e "\nstarting program"
echo -e "*******************\n"
echo -e "\nresults will be stored in current directory as results.txt"
echo "name of file? (with extension) "
read inputFile

echo "g++ $inputFile 2> results.txt"
g++ $inputFile 2> results.txt

#return value of last command stored in $?
if [ $? -eq 0 ]
then 
    echo "compiled successfully"
else
    echo "compiled with errors"
    echo "print results? y/n "
    read input
    if [ $input = "y" ]
    then 
        echo -e "\nresults: \n"
        cat results.txt
        echo " "
    fi
fi


echo -e "\n****************"
echo "end program"