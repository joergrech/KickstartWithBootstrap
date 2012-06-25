module('Formats', {
    setup: function(){
        this.input = $('<input type="text">').appendTo('#qunit-fixture');
        this.date = new Date(2012, 2, 15, 0, 0, 0, 0); // March 15, 2012
    },
    teardown: function(){
        this.input.data('datepicker').picker.remove();
    }
});

test('d: Day of month, no leading zero.', function(){
    this.input
        .val('2012-03-05')
        .datepicker({format: 'yyyy-mm-d'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[2], '5');
});

test('dd: Day of month, leading zero.', function(){
    this.input
        .val('2012-03-5')
        .datepicker({format: 'yyyy-mm-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[2], '05');
});

test('m: Month, no leading zero.', function(){
    this.input
        .val('2012-03-05')
        .datepicker({format: 'yyyy-m-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[1], '3');
});

test('mm: Month, leading zero.', function(){
    this.input
        .val('2012-3-5')
        .datepicker({format: 'yyyy-mm-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[1], '03');
});

test('M: Month shortname.', function(){
    this.input
        .val('2012-Mar-05')
        .datepicker({format: 'yyyy-M-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[1], 'Mar');
});

test('MM: Month full name.', function(){
    this.input
        .val('2012-March-5')
        .datepicker({format: 'yyyy-MM-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[1], 'March');
});

test('yy: Year, two-digit.', function(){
    this.input
        .val('2012-03-05')
        .datepicker({format: 'yy-mm-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[0], '12');
});

test('yyyy: Year, four-digit.', function(){
    this.input
        .val('2012-03-5')
        .datepicker({format: 'yyyy-mm-dd'})
        .datepicker('setValue');
    equal(this.input.val().split('-')[0], '2012');
});

test('dd-mm-yyyy: Regression: Prevent potential month overflow in small-to-large formats (Mar 31, 2012 -> Mar 01, 2012)', function(){
    this.input
        .val('31-03-2012')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '31-03-2012');
});

test('dd-mm-yyyy: Leap day', function(){
    this.input
        .val('29-02-2012')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '29-02-2012');
});

test('+1d: Tomorrow', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('+1d')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '16-03-2012');
}));

test('-1d: Yesterday', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('-1d')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '14-03-2012');
}));

test('+1w: Next week', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('+1w')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '22-03-2012');
}));

test('-1w: Last week', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('-1w')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '08-03-2012');
}));

test('+1m: Next month', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('+1m')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '15-04-2012');
}));

test('-1m: Last month', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('-1m')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '15-02-2012');
}));

test('+1y: Next year', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('+1y')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '15-03-2013');
}));

test('-1y: Last year', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('-1y')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '15-03-2011');
}));

test('-1y +2m: Multiformat', patch_date(function(Date){
    Date.now = new Date(2012, 2, 15);
    this.input
        .val('-1y +2m')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '15-05-2011');
}));

test('Regression: End-of-month bug', patch_date(function(Date){
    Date.now = new Date(2012, 4, 31);
    this.input
        .val('29-02-2012')
        .datepicker({format: 'dd-mm-yyyy'})
        .datepicker('setValue');
    equal(this.input.val(), '29-02-2012');
}));
