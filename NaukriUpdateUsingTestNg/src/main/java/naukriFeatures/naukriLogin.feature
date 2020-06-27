Feature: Login into Naukri Profile 
Scenario Outline: Login using ID and Password 

	Given Launch the browser with naukri url 
	And Enter the "<UserName>" and "<password>" 
	When Click the Login button 
	Then Verifying Naukri Profile page of "<Name>" 
	Then update the naukri prfile resume headline
	And Close the browser 
	
	Examples: 
		|Name|UserName|password|
		|Praveenkumar Sannasi Elangovan|praveen366188@gmail.com|password@1|
		|Vaibhav Agarwal|agarwal27vaibhav@gmail.com|Jagdamba$27|