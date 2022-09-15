async function handleMessage(message) {
  let rowString = "";
  let topicString = "";

  const resultBody = document.getElementById("resultTableBody");

  for (let i = 0; i < message.length; i++) {
    topicString = "";
    for (let j = 0; j < message[i].topics.length; j++) {
      topicString =
        topicString +
        `<div style=" display: inline-block; background-color: #0b7e5b; color: #dee2e1; border-radius: 6px; padding: 3px; margin-right: 3px; margin-top: 3px; margin-bottom: 3px; " > ${message[i].topics[j]} </div>`;
    }
    console.log(topicString);
    rowString =
      rowString +
      `<tr style="height: 50px"> <td style="border: 1px solid rgb(104, 207, 164)"> ${message[i].owner.login} </td> <td style="border: 1px solid rgb(104, 207, 164)"> ${message[i].name} </td> <td style="border: 1px solid rgb(104, 207, 164)"> ${topicString} </td> </tr>`;
  }

  resultBody.innerHTML = rowString;
}

(function () {
  $(function () {
    var wsTopic;
    wsTopic = new WebSocket($("section").data("ws-url"));
    return (wsTopic.onmessage = function (event) {
      var message;
      message = JSON.parse(event.data);
      return handleMessage(message);
    });
  });
}.call(this));