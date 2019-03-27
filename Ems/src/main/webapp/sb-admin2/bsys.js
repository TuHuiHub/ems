var Wo = {};
Wo.isEmpty = function (values) {
	if (values == undefined || values == '' || values == null) {
		return true;
	}
	return false;
}

/**
 * 判断值values(值以逗号隔开)中是否包含值value
 */
Wo.contains = function (values, value) {
	if (Wo.isEmpty(values)) {
		return false;
	}
	return $.inArray(value, values.split(',')) > -1;
}

/**
 * 从值values(值以逗号隔开)中删除值value
 */
Wo.removeValue = function (values, value) {
	var valueArray = values.split(',');
	valueArray = $.grep (valueArray, function (val) {
		return value != val;
	});
	return valueArray.join(',');
}

/**
 * 值values(值以逗号隔开)加上值value
 */
Wo.addValue = function (values, value) {
	if (values == undefined || values == "") {
		return value;
	}
	return [values, value].join(',');
}

