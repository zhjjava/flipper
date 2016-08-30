 $(document).ready(function() {
            //------------- Options for Supr - admin tempalte -------------//
            var supr_Options = {
                rtl:false//activate rtl version with true
            }
            //rtl version
            if(supr_Options.rtl) {
                localStorage.setItem('rtl', 1);
                $('#bootstrap').attr('href', 'css/bootstrap/bootstrap.rtl.min.css');
                $('#bootstrap-responsive').attr('href', 'css/bootstrap/bootstrap-responsive.rtl.min.css');
                $('body').addClass('rtl');
                $('#sidebar').attr('id', 'sidebar-right');
                $('#sidebarbg').attr('id', 'sidebarbg-right');
                $('.collapseBtn').addClass('rightbar').removeClass('leftbar');
                $('#content').attr('id', 'content-one')
            } else {localStorage.setItem('rtl', 0);}
            
        });