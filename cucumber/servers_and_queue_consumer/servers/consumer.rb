require "bunny"

WORDS = ['xurisso', 'teste']

conn = Bunny.new
conn.start

ch = conn.create_channel
q = ch.queue("dojo", :exclusive => true)

p = ch.queue("erro")
p.publish("teste")

q.subscribe(:block => true, :manual_ack => true) do |delivery_info, properties, payload|
  name = properties[:headers]['name']
  puts name

  unless WORDS.include?(name)
    f = File.open("files/#{name}", 'w')
    f.puts payload
    f.close
  else
    p.publish(name)
  end
end

