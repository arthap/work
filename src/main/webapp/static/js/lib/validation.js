/**
 * Created by asargsyan on 3/1/16.
 */


$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var allowedFiles = [ ".jpg", ".JPG",
            ".png" ,".PNG"];
        var fileSave = $("#fileSave");
        var imgError = $("#imgError");



        var regex = new RegExp(
            "([a-zA-Z0-9\s_()\\.\-:])+()("
            + allowedFiles.join('|')
            + ")$");
        if (!regex.test(fileSave.val()
                .toLowerCase())) {
            imgError.html("Please upload files having extensions: <b>"
            + allowedFiles
                .join(', ')
            + "</b> only.");
            return false;
        }
        imgError.html('');
        return true;
    }

);


$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var nameSave = $("#nameSave");
        var nameError = $("#nameError");

        if(nameSave.val()===null||nameSave.val()===""||nameSave.val()===" "){ nameError.html("Name is a required field")
            return false;
        }
        nameError.html('');
        return true;
    });

$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var brandSave=$("#brandSave");
        var brandError = $("#brandError");
        if(brandSave.val()===null||brandSave.val()===""||brandSave.val()===" "){ brandError.html("Brand is a required field")
            return false;
        }
        brandError.html('');
        return true;
    });

$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var regex = new RegExp("[0-9]{4}");
        var yearSave=$("#yearSave");
        var yearError = $("#yearError");
        if(!regex.test(yearSave.val())){ yearError.html("Year must be a number")
            return false;
        }
        yearError.html('');
        return true;
    });
$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var sizeSave=$("#sizeSave");
        var sizeError = $("#sizeError");
        if(sizeSave.val()===null||sizeSave.val()===""||sizeSave.val()===" "){ sizeError.html("Size is a required field")
            return false;
        }
        sizeError.html('');
        return true;
    });

$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var colorSave=$("#colorSave");
        var sizeError = $("#colorError");
        if(colorSave.val()===null||colorSave.val()===""||colorSave.val()===" "){ sizeError.html("Color is a required field")
            return false;
        }
        sizeError.html('');
        return true;
    });
$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var descriptionSave=$("#descriptionSave");
        var descriptionError = $("#descriptionError");
        if(descriptionSave.val()===null||descriptionSave.val()===""||descriptionSave.val()===" "){ descriptionError.html("Description is a required field")
            return false;
        }
        descriptionError.html('');
        return true;
    });

$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var materialSave=$("#materialSave");
        var materialError = $("#materialError");
        if(materialSave.val()===null||materialSave.val()===""||materialSave.val()===" "){ materialError.html("Material is a required field")
            return false;
        }
        materialError.html('');
        return true;
    });
$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var kategorieSave=$("#kategorieSave");
        var kategorieError = $("#kategorieError");
        if(kategorieSave.val()===null||kategorieSave.val()===""||kategorieSave.val()===" "){ kategorieError.html("Kategorie is a required field")
            return false;
        }
        kategorieError.html('');
        return true;
    });
$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var longdescriptionSave=$("#longdescriptionSave");
        var longdescriptionError = $("#longdescriptionError");
        if(longdescriptionSave.val()===null||longdescriptionSave.val()===""||longdescriptionSave.val()===" "){ longdescriptionError.html(" Long Description is a required field")
            return false;
        }
        longdescriptionError.html('');
        return true;
    });

$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var warehouseSave=$("#warehouseSave");
        var warehouseError = $("#warehouseError");
        if(warehouseSave.val()===null||warehouseSave.val()===""||warehouseSave.val()===" "){ warehouseError.html("Warehouse is a required field")
            return false;
        }
        warehouseError.html('');
        return true;
    });
$("body")
    .on(
    "click",
    "#btnSave",
    function() {
        var selectSave=$("#selectSave option:selected");
        console.log(selectSave.data);
        console.log(selectSave .text());
        console.log(selectSave.val());

        var selectError = $("#selectError");
        if(selectSave.val()==="0"){
            selectError.html("Please select Price Group")
            return false;
        }
        descriptionError.html('');
        return true;
    });
//                      $("body")
//                              .on(
//                              "click",
//                              "#btnSave", function() {
//
//                                  if($("#warehouseSave"!=" ")){
//                      location.reload();}});