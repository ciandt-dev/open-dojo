directory '/home/vagrant/.m2' do
  owner 'vagrant'
  group 'vagrant'
  action :create
end

cookbook_file '/home/vagrant/.m2/settings.xml' do
  source 'home/vagrant/dot.m2/settings.xml'
  owner 'vagrant'
  group 'vagrant'
  action :create
end

template '/home/vagrant/test' do
    source 'home/vagrant/test.erb'
    owner 'vagrant'
    group 'vagrant'
end
