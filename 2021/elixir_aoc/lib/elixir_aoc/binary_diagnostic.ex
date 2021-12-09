defmodule ElixirAoc.BinaryDiagnostics do
  use Bitwise

  def tranpose(rows) do
    rows
    |> List.zip()
    |> Stream.map(&Tuple.to_list/1)
  end

  def power_consumption(binary_list) do
    binary_list
    |> tranpose()
    |> Stream.map(&Enum.frequencies/1)
    |> Stream.map(fn
      %{0 => zero, 1 => one} when zero > one -> 0
      _otherwise -> 1
    end)
    |> Enum.join()
    |> to_charlist()
    |> then(fn x ->
      gamma = List.to_integer(x, 2)
      episoln = Integer.pow(2, length(x)) - 1 &&& bnot(gamma)
      gamma * episoln
    end)
  end

  def parse_input!(content) do
    content
    |> String.trim()
    |> String.split("\n")
    |> Stream.map(&String.graphemes/1)
    |> Stream.map(fn row ->
      row
      |> Stream.map(&Integer.parse/1)
      |> Enum.map(&elem(&1, 0))
    end)
    |> Enum.to_list()
  end

  def parse_file!(path) do
    path
    |> File.read!()
    |> parse_input!()
  end
end
