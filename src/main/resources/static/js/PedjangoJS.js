var typewriter = function(txt) {
    var container = document.getElementById('typewriter'),
        speed = 45,
        i = 0,
        wordsObj = txt.split(" ")
    container.textContent = "";
    console.log(txt)
    runAllWords();
    function runAllWords() {

        if (i < wordsObj.length) {
            var a = (i == 0) ? i : i - 1;
            setTimeout(function() {
                showWord(wordsObj[i], 0)
            }, wordsObj[a].length * speed);
        }
    }

    function showWord(word, countWord) {
        if (countWord < word.length) {
            setTimeout(function() {
                showLetter(word, countWord)
            }, speed);
        } else {
            container.textContent = container.textContent + " ";
            i += 1;
            runAllWords();
        }
        if (i === wordsObj.length) {
            console.log('complete')
        }
    }

    function showLetter(word, countWord) {
        container.textContent = container.textContent + word[countWord];
        showWord(word, countWord + 1);
    }
}

var j = 0;
function oneWord() {
    var dataType = document.getElementById('typewriter').dataset.typewriter,
        w = dataType.split(',')
    setTimeout(function () {
        typewriter(w[j]);
        j++;
    }, 2000)
}

oneWord();
