window.addEventListener('load', function () {

    (function(){
      const url = '/odontologos/listar';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         for(odontologo of data){
          var table = document.getElementById("odontologoTable");
          var odontologoRow =table.insertRow();
          let tr_id = 'tr_' + odontologo.id;
          odontologoRow.id = tr_id;
           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      odontologo.id +
                                      '</button>';
         odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_first_name\">' + odontologo.nombre.toUpperCase() + '</td>' +
                              '<td class=\"td_last_name\">' + odontologo.apellido.toUpperCase() + '</td>' +
                              '<td class=\"td_last_name\">' + odontologo.matricula+ '</td>' +
                              '<td>' + deleteButton + '</td>';

        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/odontologos.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})