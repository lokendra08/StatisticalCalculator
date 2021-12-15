# StatisticalCalculator
Calculator to perform statistical functions  max, min, mean and variance.  
Design is flexible enough to extend functinality for standard and scientific calculation.  

How to run program    
1: Clone repo into your local folder.   
2: Using Eclipse or any IDE to import project.   
3: Add junit5 library to run test cases.   
4: Just open StatCalculatorMain.java and run it as java application.   

1: Enter your numbers.   
1 press enter   
Statistics Details:  

   Total Entries:   1  
   Minimum:         1.0  
   Maximum:         1.0  
   Mean:            1.0  
   Variance:        NA  
1.0  :  1639549107887  :  Wed Dec 15 11:48:27 IST 2021  
Mean of entries in last 1 minutes  1.0  
continue to enter number OR enter 0 to exit  

2 press enter  
Statistics Details:  

   Total Entries:   2  
   Minimum:         1.0  
   Maximum:         2.0  
   Mean:            1.5  
   Variance:        0.5  
2.0  :  1639549153951  :  Wed Dec 15 11:49:13 IST 2021  
1.0  :  1639549107887  :  Wed Dec 15 11:48:27 IST 2021  
Mean of entries in last 1 minutes  1.5  
continue to enter number OR enter 0 to exit  

0 press enter  

# Program output description  
1: When program starts, It asks user to stream values, let say user input number 1 and press ENTER, program will display  
   Minimum, Maximum, Mean and Variance.  
   
   In additon to this, It will also display mean of Last entires entered in N minutes, which in case 1 minute by default.  
   This value can be configured in an external file.  
   
   
# Assumptions:
1: Negative entires not allowed, this will error out with appropriate message.


