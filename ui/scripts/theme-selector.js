var theme_selector = (function($, window, undefined) {
  var api = {};
  var themes = [
    {id: "classic", name: "Classic"},
    {id: "sea", name: "The Sargasso Sea"},
    {id: "safari", name: "African Safari"},
    {id: "papaya", name: "Papaya Sundae"},
    {id: "subway", name: "Subway"},
    {id: "helveti", name: "Helveti"},
    {id: "helvetiblue", name: "Helveti Blue"},
  ];

  var getThemes = function() {
    var currentTheme = $.cookie('theme') ? $.cookie('theme') : 'classic';
    for (var i = 0; i < themes.length; i++) {
      themes[i].checked = null;
      if (themes[i].id == currentTheme) {
        themes[i].checked = true;
      }
    }

    return {themes: themes, currentTheme: currentTheme};
  }

  api.getModal = function() {
    var themes = getThemes();
    var str = '<table style="width:100%;">';
    for (var i = 0; i < themes.themes.length; i++) {
      str += '<tr><td style="margin:2px;">';
      str += '<input type="radio" onclick="theme_selector.setTheme(\'' + themes.themes[i].id + '\');" name="theme" id="choice_' + i + '"';
      if (themes.themes[i].checked) {
        str+= ' checked="checked"';
      }
      str += '/>';
      str += '<label for="choice_' + i + '">' + themes.themes[i].name + '</label>';
      str += '</td></tr>';
    }
    str += '</table>';
    return str;
  }

  api.setTheme = function(theme) {
    var whitelisted = false;
    var themes = getThemes();
    for (var i = 0; i < themes.themes.length; i++) {
      if (theme == themes.themes[i].id) {
        whitelisted = true;
      }
    }

    if (!whitelisted) {
      return;
    }

    $('#cssLink').attr('href', '/css/themes/' + theme + '.css');
    $.cookie('theme', theme);
  }

  return api;
}(jQuery, window));
