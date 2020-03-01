#!/bin/bash


echo -e "\nstarting program"
echo -e "*******************\n"
echo "name of file? (with extension) "
read inputFile

echo "g++ $inputFile 2> results.txt"
g++ $inputFile 2> results.txt

echo -e "finished \n"

if [ -z "results.txt" ]
then 
    echo "compiled successfully"
else
    echo "compiled with errors"
    echo "print results? y/n "
    read input
    if [ $input = "y" ]
    then 
        echo -e "results: \n"
        cat results.txt
        echo " "
    fi
fi


echo -e "\n****************"
echo "end program"




