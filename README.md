tDash
=====

A Twitter Dashboard

## Testing

1. Install [virtualbox][3], [vagrant][4] and [vagrant-vbguest][5].
2. Clone this repository.
3. Run `vagrant up`, `vagrant ssh`, `cd /vagrant`, `make compile`, `./runWebServer.sh`.
4. Add your twitter app API keys in `build/ROOT/WEB-INF/web.xml`.
5. Browse to http://127.0.0.1:8080.

## Copyright & License ##
Copyright 2013 Harshad RJ
License: GPL V3 (See `LICENSE` for details.)

[1]: https://github.com/yui/yuicompressor/downloads
[2]: http://www.scala-sbt.org
[3]: https://www.virtualbox.org/
[4]: http://www.vagrantup.com/
[5]: http://kvz.io/blog/2013/01/16/vagrant-tip-keep-virtualbox-guest-additions-in-sync/
