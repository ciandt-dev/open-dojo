require "sinatra"

get '/api/:name' do
  content_type 'plain/text'

  puts File.exists?("files/#{params[:name]}")
  if File.exists?("files/#{params[:name]}")
    File.open("files/#{params[:name]}").read
  else
    status 404
  end
end
