function eliminar(id)
{
    swal({
      title: "Estas seguro de eliminar?",
      text: "Una vez eliminado, no podrá recuperar este archivo!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
            $.ajax({
            url:"/eliminar/"+id,
            success: function(res){
                console.log(res);
            }
            });
        swal("Poof! Su archivo ha sido eliminado!", {
          icon: "success",
        }).then(()=>{
            if(ok){
                location.href="/empleados";
            }
        });
      } else {
        swal("Tu archivo ha sido Guardado!");
      }
    });
}