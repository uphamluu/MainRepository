
function emptyDiv(node) {
	node.innerHTML = "";
}

function copyText() {
	
	var result = document.getElementById("resultTxt");
	resultTxt.select();
	console.log(result.value);
	
	try {
	    var successful = document.execCommand('copy');
	    var msg = successful ? 'successful' : 'unsuccessful';
	  } catch (err) {
	    alert('Oops, unable to copy');
	  }
}


function searchWordAndDisplay() {
				
	// find the place to display element
	var wordTxtBx = document.getElementById("wordTxt");
	var textToSearch = wordTxtBx.value.trim().toLowerCase();
	var temp =  document.getElementById("placeholder");
	emptyDiv(temp);
	if (textToSearch.length>0){
			
		for (i = 0; i < dictionary.length; i++) { 
			var tobesearched = dictionary[i]['word'].trim().toLowerCase();
			
			var pos = tobesearched.search(textToSearch);
				
			if (pos> -1) {
				displayEntry(temp, dictionary[i] );
				displayEntry2(dictionary[i])
						
			}
		}	
	}			
			
}


function createParagraph(parentDiv, cssClassName, textToDisplay){
	var para = document.createElement("p");
	para.className = cssClassName ;
	var node = document.createTextNode(textToDisplay);
	para.appendChild(node);	
	parentDiv.appendChild(para);
	
	
}
function displayEntry2 (dictEntry) {
	var adj = document.getElementById("adjTxt").value;
	var gender = dictEntry['gender'].toLowerCase() ;
	var genderIncase = findGenderIncase(adj, gender);
	
	
	var textToDiplay = genderIncase + " " +dictEntry['word']
	
	// *******************
	var resultTxt = document.getElementById("resultTxt");
	resultTxt.value = textToDiplay;
	
}

function findGenderIncase (adj, gender) {
	
	var caseID =  document.getElementById("caseID").value.toLowerCase();
	var artikelType =  document.getElementById("artikelType").value.toLowerCase();
//	console.log('input: '+caseID+" "+artikelType+" "+ gender);

	var result = 'FEHLER';
	for (i = 0; i < adjEndCombination.length; i++) {
//			console.log('----------');
			

			var caseTobeSearched = adjEndCombination[i]['incase'].trim().toLowerCase();
			var artikelTypeTobeSearched = adjEndCombination[i]['artikelType'].trim().toLowerCase();
			var genderTobeSearched = adjEndCombination[i]['gender'].trim().toLowerCase();

//			console.log('value:: '+caseTobeSearched+" "+artikelTypeTobeSearched+" "+ genderTobeSearched);
							
			if (caseID == caseTobeSearched && artikelType == artikelTypeTobeSearched && gender == genderTobeSearched) {
				
				result = adjEndCombination[i]['artikelValue'] + " "+ adj + adjEndCombination[i]['eValue'];
				
					
			}
	}
  return result;
	
	
	
}





function displayEntry (parentElement, dictEntry) {
	
	var entryDiv = document.createElement("div");
	entryDiv.className="entryDiv oddRow";
	
	entryDiv.className="entryDiv evenRow";
	
	entryDiv.setAttribute( "onmouseover", "javascript: changeBGOn(this);" );
	entryDiv.setAttribute( "onmouseout", "javascript: changeBGOut(this);" );
	
	
	
	var textToDisplay = 'Gender:'+ dictEntry['gender'];
	createParagraph(entryDiv, "Gender", textToDisplay);
	
	var textToDisplay = 'Word: '+dictEntry['word'];
	createParagraph(entryDiv, "Word", textToDisplay);
		
	var textToDisplay = 'WordFunction: '+dictEntry['word_function'];
	createParagraph(entryDiv, "WordFunction", textToDisplay);
	
	var textToDisplay = 'Meaning: '+dictEntry['meaning'];
	createParagraph(entryDiv, "Meaning", textToDisplay);
	
	var textToDisplay = 'Example: '+dictEntry['example'];
	createParagraph(entryDiv, "Example", textToDisplay);
	
	
	var link = document.createElement('a');
	var linkText = document.createTextNode('Super Concept: ' + dictEntry['superConcept']);
	link.appendChild(linkText);
    link.href='#'+dictEntry['superConcept']+"_id";
    entryDiv.appendChild(link);
	
	
	var textToDisplay = 'SubConcept: '+dictEntry['subConcept'];
	createParagraph(entryDiv, "subConcept", textToDisplay);
	
	parentElement.appendChild(entryDiv);
	
}

function changeBGOn(divElement) {
	var currentClass= divElement.className;
	var temp = currentClass.replace("oddRow","onOddRow");
	temp = temp.replace("evenRow","onEvenRow");	
	divElement.className= temp;
}

function changeBGOut(divElement) {
	var currentClass= divElement.className;
	var temp = currentClass.replace("onOddRow","oddRow");
	temp = temp.replace("onEvenRow","evenRow");	
	divElement.className= temp;
}


