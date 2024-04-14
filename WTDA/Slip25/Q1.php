<?php
//CreateanewDOMdocument
$doc=newDOMDocument();
//Createtherootelement
$cricketTeam=$doc->createElement(“CricketTeam”);
//CreatethefirstteamelementforAustralia
$teamAustralia=$doc->createElement(“Team”);
$teamAustralia->setAttribute(“country”,“Australia”);
//Createtheplayerelementandsetitsvalue
$player1=$doc->createElement(“player”,“SteveSmith”);
$teamAustralia->appendChild($player1);
//Createtherunselementandsetitsvalue
$runs1=$doc->createElement(“runs”,“7090”);
$teamAustralia->appendChild($runs1);
//Createthewicketelementandsetitsvalue
$wicket1=$doc->createElement(“wicket”,“17”);
$teamAustralia->appendChild($wicket1);
//Appendtheteamelementtotherootelement
$cricketTeam->appendChild($teamAustralia);
//CreatethesecondteamelementforIndia
$teamIndia=$doc->createElement(“Team”);
$teamIndia->setAttribute(“country”,“India”);
//Createtheplayerelementandsetitsvalue
$player2=$doc->createElement(“player”,“ViratKohli”);
$teamIndia->appendChild($player2);
//Createtherunselementandsetitsvalue
$runs2=$doc->createElement(“runs”,“12169”);
$teamIndia->appendChild($runs2);
//Createthewicketelementandsetitsvalue
$wicket2=$doc->createElement(“wicket”,“4”);
$teamIndia->appendChild($wicket2);
//Createthecategoryelementandsetitsvalue
$category=$doc->createElement(“category”,“Captain”);
$teamIndia->appendChild($category);
//Appendtheteamelementtotherootelement
$cricketTeam->appendChild($teamIndia);
//Appendtherootelementtothedocument
$doc->appendChild($cricketTeam);
//SavetheXMLfile
$doc->save(“cricket.xml”);
Echo“Elementsaddedsuccessfully!”;
?>